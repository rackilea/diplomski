Piggy koumparas;
if (arxiko_poso.equals("")) {
    koumparas = new Piggy();
} else {
    float init_value = Float.parseFloat(arxiko_poso);
    koumparas = new Piggy(init_value);
}

float upoloipo = koumparas.epistrofiYpoloipou();