// k is 1 so call findCombos with 0
findCombos(subList, temp, k - 1, combos);

// k is 0 so add temp to combos
if (k == 0) {
    combos.add(temp);
}

// on return, immediately mutate temp
temp.remove(temp.size() - 1);