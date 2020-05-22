List<Cat> currentCats = getAllCats();
        for (Cat cat : catsFromServier) {
            int index = currentCats.indexOf(cat);
            if (index != -1) {
                cat.setHeads(currentCats.get(index).getHeads);
            }
        }