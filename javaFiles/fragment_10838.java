public List<User> getAllFilterByString(String text) {

    if(StringUtils.isEmpty(text))
        return userRepository.findAll();

    Specification<User> specification =
            (root, query, cb) -> {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(cb.like(cb.lower(root.get("name")), "%"+text.toLowerCase()+"%"));

                //check if the text value can be casted to long.
                //if it is possible, then add the check to the query
                try {
                    long longValue = Long.valueOf(text);
                    predicates.add(cb.equal(root.get("id"), longValue));
                }
                catch (NumberFormatException e) {
                    //do nothing, the text is not long
                }

                //check if the text can be casted to boolean
                //if it is possible, then add the check to the query

                Boolean value = "true".equalsIgnoreCase(text) ? Boolean.TRUE :
                        "false".equalsIgnoreCase(text) ? Boolean.FALSE : null;

                if(value != null) {
                    predicates.add(cb.equal(root.get("isActive"), value));
                }

                return cb.or(predicates.toArray(new Predicate[] {}));
            };

    return userRepository.findAll(specification);

}