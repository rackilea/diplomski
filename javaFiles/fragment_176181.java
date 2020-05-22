List<Integer> marks = List.of(86, 74, 90, 40); //some dummy list of marks
Map<String, List<Integer>> map = marks.stream()
        .collect(Collectors.groupingBy(o -> {
            if (o < 50) return "F"; //assign grade 'F' to marks less than 50
            if (o < 65) return "1"; //assign grade '1' to marks from 50 to 64
            if (o < 75) return "2"; //65 to 74
            return "R"; //grade 'R' to 75 and above
        }));
System.out.println(map);