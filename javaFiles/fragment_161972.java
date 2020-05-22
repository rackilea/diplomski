List<LabelValueBean> colorcodeList = new ArrayList<LabelValueBean>();
for (Mty property : customPropertyList) {
            LabelValueBean bean = new LabelValueBean(property.getName(), property.getId().toString());

if (property instanceof ColorCode) {
                test1 = property.getName();
                System.out.println("test1: " + test1);
                request.setAttribute("test1", "background: "+test1+";");
                colorcodeList.add(bean);
            }

}