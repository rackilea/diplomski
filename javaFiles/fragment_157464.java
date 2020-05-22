distance = _mm_cvtps_pd(_mm_sqrt_ps(_mm_cvtpd_ps(dsquared)));
// now  dsquared == distance^2 rather than dsquared == 1/distance^2

// Babylonian method: to find the square root x of a number S,
// iterate x_{n+1} = 0.5 * (x_n + S/x_n)
for (m=0; m<2; ++m)
  distance = _mm_set1_pd(0.5) * (distance + dsquared/distance);

// was: dmag = _mm_set1_pd(dt) / dsquared * distance;
dmag = _mm_set1_pd(dt) / (dsquared * distance);