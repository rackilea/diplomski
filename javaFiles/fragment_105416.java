@WebMethod
public CustomObject create(CustomObject2 object)
   CustomObject co = ... // Get CustomObject from third party library

   CustomObjectJAXB coJaxb = new CustomObjectJAXB()
   BeanUtils.copyProperties (coJaxb,co);
   return coJaxb;
}