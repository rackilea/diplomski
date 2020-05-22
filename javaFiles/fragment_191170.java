if (s_contains_notas.length() <= 0 || !s_contains_notas.matches("[^0-9]+")) {

                list = new ArrayList<>();
                Pattern PATTERN = Pattern.compile("[-]?[0-9]+(?:[,.][0-9]+)?");

                s_contains_notas = s_contains_notas.replaceAll("," , ".");
                Matcher m = PATTERN.matcher(s_contains_notas);
                while (m.find()) {
                    list.add(m.group());

                }

                double[] d_notas = new double[list.size()]; //create an array with the size of the failList

                for (int i = 0; i < list.size(); ++i) { //iterate over the elements of the list
                    d_notas[i] = Double.parseDouble(list.get(i)); //store each element as a double in the array
                }

                double d_sum_notas = 0;
                for (Double d : d_notas) {
                    d_sum_notas += d;
                }

                s_euros = String.valueOf(d_sum_notas);
                et_euros.setText(nf_locale.format(d_sum_notas));
            }