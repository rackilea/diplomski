JMenuBar menuBar=new JMenuBar();
JMenu functionsMenu=new JMenu("Functions");
JMenuItem[] classes=new JMenuItem[myClasses.length];
for(int i=0;i<ClassInfo.classes.length;i++) {
    String[][] classMethods=ClassInfo.showMethodsForClass(ClassInfo.classes[i]);//  { {static} , {instance} }
    final String className=ClassInfo.classes[i].getSimpleName();
    JMenuItem[] staticMethodsItem=new JMenuItem[classMethods[0].length];
    JMenuItem[] instanceMethodsItem=new JMenuItem[classMethods[1].length];
    JMenu staticMenu=new JMenu("Static Methods");
    JMenu instanceMenu=new JMenu("Instance Methods");

    for(int a=0;a<classMethods[0].length;a++)   {
        final String methodName=classMethods[0][a];
        staticMethodsItem[a]=new JMenuItem(methodName);
        staticMethodsItem[a].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                ClassInfo.copyToClipBoard(ClassInfo.staticWriteableString(methodName,className));
            }
        });
        staticMenu.add(staticMethodsItem[a]);
    }

    for(int a=0;a<classMethods[1].length;a++)   {
        final String methodName=classMethods[1][a];
        instanceMethodsItem[a]=new JMenuItem(methodName);
        instanceMethodsItem[a].addActionListener(new ActionListener()   {
            public void actionPerformed(ActionEvent e)  {
                ClassInfo.copyToClipBoard(ClassInfo.instanceWriteableString(methodName));
            }
        });
        instanceMenu.add(instanceMethodsItem[a]);
    }

    classes[i]=new JMenu(className);
    classes[i].add(staticMenu); //add static method submenu to the new class submenu
    classes[i].add(instanceMenu);//add instance method submenu to the new class submenu
    functionsMenu.add(classes[i]); //Add a new class in the functions menu
}
menuBar.add(functionsMenu);