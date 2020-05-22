public boolean validateLabels(Object object) {
        Class<?> validationClass = object.getClass();

        for (Field field: validationClass.getDeclaredFields()) {
            if(field.getType() ==  WebElement.class && field.isAnnotationPresent(ExpectedLabel.class)){
                field.setAccessible(true);
                ExpectedLabel expectedLabel = field.getAnnotation(ExpectedLabel.class);
                if (StringUtils.isNotBlank(expectedLabel.label())){
                    try {
                        WebElement element = (WebElement) field.get(object);
                        if(!StringUtils.equals(element.getText(), expectedLabel.label())){
                            LoggerUtil.warn("O campo "+field.getName()+" da Page "+validationClass.getSimpleName()+" tem um label invalido! Esperado : ("+expectedLabel.label()+") Obtido: ("+element.getText()+")!", validationClass.getSimpleName());
                        }
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }