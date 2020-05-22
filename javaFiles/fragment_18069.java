float cornerX = Float.MAX_VALUE;
float cornerY = Float.MAX_VALUE;

if (ltime != Float.MAX_VALUE) {
   cornerX = L;
} else if (rtime != Float.MAX_VALUE) {
   cornerX = R;
}

if (ttime != Float.MAX_VALUE) {
   cornerY = T;
} else if (btime != Float.MAX_VALUE) {
   cornerY = B;
}

// Account for the times where we don't pass over a side but we do hit it's corner
if (cornerX != Float.MAX_VALUE && cornerY == Float.MAX_VALUE) {
   cornerY = (dy > 0.0f ? B : T);
}

if (cornerY != Float.MAX_VALUE && cornerX == Float.MAX_VALUE) {
   cornerX = (dx > 0.0f ? R : L);
}