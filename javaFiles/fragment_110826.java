// Force H to unit length
final float invH = 1.0f / normH;
Hx *= invH;
Hy *= invH;
Hz *= invH;

// Force A to unit length
final float invA = 1.0f / (float)Math.sqrt(Ax*Ax + Ay*Ay + Az*Az);
Ax *= invA;
Ay *= invA;
Az *= invA;