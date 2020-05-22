@GetMapping("/profile/client-users/{userId}")
    public ModelAndView getAccountAccess(
        @PathVariable String userId, ModelMap modelMap) {
        String decoded = new String(java.util.Base64.getDecoder().decode(userId.getBytes()));
        userId = EncryptionUtil.decrypt(decoded);
}