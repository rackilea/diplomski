if (row != 0 && row != (size - 1) && col != 0 && col != (size - 1)) {
            n[0][0] = houses[victim.address - 1][victim.j];
            n[0][1] = houses[victim.address + 1][victim.j];
            n[0][2] = houses[victim.address - size][victim.j];
            n[0][3] = houses[victim.address - size - 1][victim.j];
            n[0][4] = houses[victim.address - size + 1][victim.j];
            n[0][5] = houses[victim.address + size][victim.j];
            n[0][6] = houses[victim.address + size - 1][victim.j];
            n[0][7] = houses[victim.address + size + 1][victim.j];
            return n;
        }