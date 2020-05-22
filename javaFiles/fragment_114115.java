public Map<Integer, List<CustomClass>> categorize(List<CustomClass> customClass) {
        Map<Integer, List<CustomClass>> returnValue = new HashMap<>();

        for (CustomClass customClassValue: customClass) {
            List<CustomClass> sublist = returnValue.get(customClassValue.getAge());

            if (sublist == null) {
                sublist = new ArrayList<>();
                returnValue.put(customClassValue.getAge(), sublist);
            }

            sublist.add(customClassValue);
        }

        return returnValue;
    }