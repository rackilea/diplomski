boolean found = false;
for (Paragem p : paragems) {
    if (p.nomeParagem.equals(pickName)) { // Or use an accessor function for `nomeParagem` if appropriate
        found = true;
        break;
    }
}