/* solve problem stated in:
 * http://stackoverflow.com/questions/22099321/calculate-inverse-of-normal-function-that-minimizes-another-function
 *
 * copyright 2014 by Robert Dodier
 * I release this work under terms of the GNU General Public License
 *
 * how to:
 *
 * (1) assign values to m1, s1, m2, s2, x1, y1, and z0
 * (2) batch("foo.mac");
 *
 * example:
 *
 * [m1, s1, m2, s2, x1, y1, z0] : [-2, 1.8, 1.3, 2.4, 1.82, -0.24, 0.3];
 * batch ("foo.mac");
 *  => [x0, y0] = [- .4249300563696112, 0.172672148095035]
 *
 * after that, try:
 *
 * set_plot_option ([same_xy, true]);
 * load (implicit_plot);
 * implicit_plot ([F (x, y) = z0, (x - x1)^2 + (y - y1)^2 = r0^2], [x, -5, 5], [y, -5, 5]), numer;
 *
 * should show z0 contour just touching the circle of radius r0 centered on [x1, y1]
 */

load (distrib);
ratprint : false;

/* m1, s1, m2, s2 must be assigned values */

F (x, y) := pdf_normal (x, m1, s1) + pdf_normal (y, m2, s2);

/* x1, y1 must be assigned values */

G (r, x1, y1) := fmax_circular (lambda ([t], F (x1 + r * cos (t), y1 + r * sin (t))));

fmax_circular (f) := lmax (map (f, fargmax_circular (f)));

fargmax_circular (f) := block ([n : 17, u0, u2],
  map (f, makelist (i * 2 * float (%pi) / n, i, 0, n)),
  ev (sublist_indices (%%, lambda ([u], u = u_max)), u_max = lmax (%%)),
  map (lambda ([i], [u0, u2] : [(i - 1) * 2 * float (%pi) / n, (i + 1) * 2 * float (%pi) / n], fargmax1 (f, u0, u2)), %%));

/* golden section search */

fargmax1 (f, u0, u2) := block ([tol : 1e-2, u1 : u0 + (u2 - u0) / float (%phi)],
  while u2 - u0 > tol
    do block ([x],
      if u2 - u1 > u1 - u0
        then x : u1 + (1 - 1/float (%phi)) * (u2 - u1)
        else x : u1 - (1 - 1/float (%phi)) * (u1 - u0),
      if f(x) > f(u1)
        then /* accept interval containing x */
          if u2 - u1 > u1 - u0
            then [u0, u1, u2] : [u1, x, u2]
            else [u0, u1, u2] : [u0, x, u1]
        else /* reject interval containing x */
          if u2 - u1 > u1 - u0
            then [u0, u1, u2] : [u0, u1, x]
            else [u0, u1, u2] : [x, u1, u2]),
  u0 + (u1 - u0) / 2);

/* z0 must be assigned a value */

r0 : find_root (lambda ([r], G (r, x1, y1) - z), r, 0.001, 5), z = z0, numer;

/* fargmax_circular returns a list -- assume it's just one element
 * not guaranteed to work -- [t0] : ... fails when rhs has 2 or more elements, oh well
 */
[t0] : fargmax_circular (lambda ([t], F (x1 + r0 * cos (t), y1 + r0 * sin (t))));

/* [x0, y0] is the point on z0 contour of F, nearest to [x1, y1]
 * r0 is distance from [x1, y1] to [x0, y0]
 */

[x0, y0] : [x1 + r0 * cos (t0), y1 + r0 * sin (t0)];

F (x0, y0), numer; /* should be equal to z0 */