public List<MyBean> findByNation(String nation) {
    if (nation != null) {
        nation = nation.toUpperCase();
    } else {
        nation = "";
    }

    [...]
}