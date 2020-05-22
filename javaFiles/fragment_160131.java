koch(n - 1, size / 3);   // line 1
    t.rotate(120);            // line 2
    koch(n - 1, size/3);     // line 3
    t.rotate(120);           // line 4
    koch(n - 1, size/3);     // line 5
    t.rotate(-60);            // line 6
    koch(n - 1, size/3);     // line 7