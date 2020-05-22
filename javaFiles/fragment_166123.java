// calc
        for (Node suc : successor) {
            if (suc.x == (int) this.screen.character.mapPos.x
                    && suc.y == (int) this.screen.character.mapPos.y)
                return suc;
            boolean add = true;
            if (betterIn(suc, openList)) // openList und der
                add = false;
            if (betterIn(suc, closeList)) // closedList
                add = false;
            if (add)
                openList.add(suc);
        }