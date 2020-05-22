ListView houseListView = root.findViewById(R.id.houseList);
        repository = HouseRepository.getInstance();
        houses = repository.searchHouses(10, 0, "Id", OrderType.ASC).getValue();
        adapter = new HouseListAdapter(root.getContext(), houses);
        adapter.setNotifyOnChange(true);
        houseListView.setAdapter(adapter);
        for (House house : houses) {
            adapter.add(house);
        }