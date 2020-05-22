public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {   
        //...
    }

    @Override
    public void validate(Object target, Errors errors) {

        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        SimpleGrantedAuthority userRole = new SimpleGrantedAuthority("ROLE_USER");

        if (authorities.contains(userRole)) {

            ItemEntity item = (ItemEntity) target;
            prevItem = item.getPreviousState();

            String prevName = prevItem.getName();
            String prevCreator = prevItem.getCreator();
            String newName = item.getName();
            String newCreator = item.getCreator();

            if (!prevName.equals(newName)) {
                errors.rejectValue("name", "You cannot change Name field!");
            }

            if (!prevCreator.equals(newCreator)) {
                errors.rejectValue("creator", "You cannot change Creator field!");
            }
        }
        // Other checks...
    }
}