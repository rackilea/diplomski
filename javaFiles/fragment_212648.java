ris = ris.replace("[ID]", p.getId())
        .replace("[CODE]", p.getCode())
        .replace("[MODEL]", p.getModel());

if (p instanceof Pc) {
    ris = ris.replace("[CPU]", ((Pc) p).getCPU())
            .replace("[RAM]", ((Pc) p).getRam() + "")
            .replace("[MMA]", ((Pc) p).getMma() + "")
            .replace("[RAMTYPE]", ((Pc) p).getRamType())
            .replace("[MMATYPE]", ((Pc) p).getMmaType());
} else if (p instanceof Laptop) {
    ris = ris.replace("[BATTERYLIFE]", ((Laptop) p).getOrebatteria() + "")
            .replace("[INCHES]", ((Laptop) p).getPollici() + "");
} else if (p instanceof Smartphone) {
    ris = ris.replace("[NETWORK]", ((Smartphone) p).getNetwork())
            .replace("[MEGAPIXEL]", ((Smartphone) p).getMegapixel() + "")
            .replace("[JACK]", ((Smartphone) p).getJack());
}