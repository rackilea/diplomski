@DeleteMapping("{cId}")
    public String delete(@PathVariable String cId) {
         List<String> arr=new ArrayList<String>(3);
         arr.add("A");
         arr.add("B");
         arr.add("C");
         arr.remove(cId);
         for (String string : arr) {
            System.out.println(string);
        }

        return "redirect:/compare";
    }