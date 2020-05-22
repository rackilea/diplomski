double []values = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 0.10, 0.11, 0.12};

ArrayList<ArrayList<Double>> mainList = new ArrayList();
int k = 0;
for(int i = 0; i < values.length; i += 3)
{
  ArrayList<Double> list = new ArrayList();
  list.add(values[i]);
  list.add(values[i + 1]);
  list.add(values[i + 2]);

  mainList.set(k ++, list);
}