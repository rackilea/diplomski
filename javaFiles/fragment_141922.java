ArrayList<String> listItems = new ArrayList<String>();
        listItems.add("1 * 10 = 10");
        listItems.add("2 * 10 =  20");
        listItems.add("1 * 5 = 5");
        listItems.add("2 * 10 = 20");

        Map<Integer, CashModal> cashModalsMap = new HashMap<Integer, CashModal>();
        int subTotal = 0;
        int existingCount = 0;
        int existingSubtotal = 0;
        for (String s : listItems) {
            String x[] = s.split("\\*");
            if (!cashModalsMap
                    .containsKey(Integer.parseInt(x[1].split("\\=")[0].trim()))) {
                CashModal cashModal = new CashModal();

                cashModal.setCount(Integer.parseInt(x[0].trim()));
                cashModal.setCurrency(Integer.parseInt(x[1].split("\\=")[0]
                        .trim()));
                cashModal.setSubTotal(Integer.parseInt(x[1].split("\\=")[1]
                        .trim()));
                cashModalsMap.put(
                        Integer.parseInt(x[1].split("\\=")[0].trim()),
                        cashModal);
                subTotal = subTotal
                        + Integer.parseInt((x[1].split("\\=")[1]).trim());
            } else {
                CashModal cashModalExisting = cashModalsMap.get(Integer
                        .parseInt(x[1].split("\\=")[0].trim()));
                existingCount = cashModalExisting.getCount();
                existingSubtotal = cashModalExisting.getSubTotal();
                cashModalExisting.setCount(existingCount
                        + Integer.parseInt(x[0].trim()));
                cashModalExisting.setSubTotal(existingSubtotal
                        + Integer.parseInt(x[1].split("\\=")[1].trim()));
                cashModalsMap.put(
                        Integer.parseInt(x[1].split("\\=")[0].trim()),
                        cashModalExisting);
            }
        }
        for(CashModal cm:cashModalsMap.values()){
        System.out.println("Count:"+cm.getCount()+",Currency:"+cm.getCurrency()+",SubTotal:"+cm.getSubTotal());
        }
    }