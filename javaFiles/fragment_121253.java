b1.addActionListener(new ActionListener() {
    private List<String> operaters=Arrays.asList(new String []{">", "<", "!", "==", "<=", ">="});
    private String filterPattern="[0-9]|[A-Z]|[a-z]|[0-9]";
    public void actionPerformed(ActionEvent e) {           
        applyFilter(jtf1.getText(),0);

    }

    private void applyFilter(String text,int columnIndex) {
        if (text.length() == 0) {
            //sorter.setRowFilter(null);
        }else{


            String operator=text.toString().split(filterPattern)[0];
            if(operaters.contains(operator)){
                String value=text.split(operator).length>1?text.split(operator)[1]:"";
                sorter.setRowFilter(getRowFilter(operator,value,columnIndex));
            }

        }

    }

    private RowFilter<? super TableModel, ? super Integer> getRowFilter(
            String operator, String value,int columnIndex) {

        if (operator.equals("==")) {
            return RowFilter.regexFilter(value);
        } else if (operator.equals("!")) {

            return RowFilter.notFilter(RowFilter.regexFilter(value,columnIndex));
        }

        else if (operator.equals(">")) {

            return RowFilter.numberFilter(ComparisonType.AFTER,
                    Integer.parseInt(value),columnIndex);
        } else if (operator.equals("<")) {

            Number numb = Integer.parseInt(value);

            return RowFilter.numberFilter(ComparisonType.BEFORE, numb,columnIndex);
        } else if (operator.equals(">=")) {

            Number numb = Integer.parseInt(value);
            // String s=text.substring(2);
            List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(
                    2);

            filters.add(0,
                    RowFilter.numberFilter(ComparisonType.EQUAL, numb,columnIndex));
            filters.add(0,
                    RowFilter.numberFilter(ComparisonType.AFTER, numb,columnIndex));

            return RowFilter.orFilter(filters);
        }

        else if (operator.equals("<=")) {

            Number numb = Integer.parseInt(value);
            // String s=text.substring(2);
            List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(
                    2);

            filters.add(0,
                    RowFilter.numberFilter(ComparisonType.EQUAL, numb,columnIndex));
            filters.add(0,
                    RowFilter.numberFilter(ComparisonType.BEFORE, numb,columnIndex));
            return RowFilter.orFilter(filters);
        }
        return null;
    }
    }
);