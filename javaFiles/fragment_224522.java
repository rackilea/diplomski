category = new String[costs.size()];
amount = new Float[costs.size()];
int i = 0;
for (Map.Entry<String, Float> entry: costs.entrySet()) {
    category[i] = entry.getKey();
    amount[i] = entry.getValue();
    ++i;
}