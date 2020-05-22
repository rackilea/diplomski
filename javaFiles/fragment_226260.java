String stat = "Arif||44444~Balin||33333~Cavin||55555~Den||66666~";
    String[] parts = stat.split("~");
    List<String> names = new ArrayList<>();
    List<String> numbers = new ArrayList<>();

    for(int i = 0; i < parts.length; i++) {         
        names.add(parts[i].split("[\\W]{2}")[0]);          
        numbers.add(parts[i].split("[\\W]{2}")[1]);
    }