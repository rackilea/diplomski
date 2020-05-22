Double Computing(String equation) {
    String replace = equation.replace("+", " + ").replace("x", " x ").replace("-", " - ").replace("/", " / ");
    List<Object> list = new ArrayList<>(Arrays.asList(replace.split("\\s+")));

    for (int i = 0; i < list.size(); i++) {
        try {
            list.set(i, Double.parseDouble(list.get(i).toString()));
        } catch (NumberFormatException e) {
        }
    }

    while (list.contains("x")) {
        int i = list.indexOf("x");
        double mult = (Double) list.get(i - 1) * (Double) list.get(i + 1);
        list.remove(i + 1);
        list.set(i, mult);
        list.remove(i - 1);
    }
    while (list.contains("/")) {
        int i = list.indexOf("/");
        double div = (Double) list.get(i - 1) / (Double) list.get(i + 1);
        list.remove(i + 1);
        list.set(i, div);
        list.remove(i - 1);
    }
    double sum = (Double) list.get(0);
    for (int i = 1; i < (list.size() - 1); i += 2) {
        if (list.get(i).equals("+")) {
            sum += (Double) list.get(i + 1);
        } else {
            sum -= (Double) list.get(i + 1);
        }
    }

    return sum;
}