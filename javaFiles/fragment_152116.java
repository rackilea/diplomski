<mytag:combo id="combo1" 
         value="#{bean.firstData}" 
         model="#{globalBean.getList()}"
         update="form1:combo2"   />

<mytag:combo id="combo2" 
         value="#{bean.secondData}" 
         model="#{globalBean.getSubList(bean.firstData)}"  />