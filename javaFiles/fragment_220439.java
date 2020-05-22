String str[] = phrase.split(" ");
StringBuilder stringBuilder = new StringBuilder();
for (int i =0; i< Math.min(str.length, 3); i++) {
    stringBuilder.append(str[i] + " ");
}

System.out.println(stringBuilder.toString().replaceAll(" $", ""));