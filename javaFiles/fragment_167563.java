//HParallelGroup2.addComponent(textarea);
    HParallelGroup2.addComponent(scroll);
    HParallelGroup3.addComponent(button);

    HorSGroup.addGroup(HParallelGroup1); //Horizontālās grupas tiek pievienotas sakārtotajai grupai
    HorSGroup.addGroup(HParallelGroup2);
    HorSGroup.addGroup(HParallelGroup3);

    GroupLayout.ParallelGroup VerPGroup1= groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE); //Izveido Vertikālās grupas.
    GroupLayout.ParallelGroup VerPGroup2= groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);
    GroupLayout.ParallelGroup VerPGroup3= groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);

    VerPGroup1.addComponent(label1); //Pievieno objektus
    VerPGroup1.addComponent(textbox1);
    VerPGroup1.addComponent(button);
    VerPGroup2.addComponent(label2);
    VerPGroup2.addComponent(textbox2);
    //VerPGroup3.addComponent(textarea);
    VerPGroup3.addComponent(scroll);