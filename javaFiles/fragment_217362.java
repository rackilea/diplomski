Promotion promotion = .... 
modelMap.addAttribute("promotion", promotion); 
if (!promotion.validate()) {
    BindingResult errors = new BeanPropertyBindingResult(promotion, "promotion");
    errors.reject("promotion.invalid");
    model.put(BindingResult.MODEL_KEY_PREFIX + "promotion", errors);
}