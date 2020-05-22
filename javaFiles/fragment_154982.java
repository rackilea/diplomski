while(!Front.get(front).isEmpty()){
        Q.clear();
        for(int i=0;i<Front.get(front).size();i++){
            if(!Individual_Dominate.get(Front.get(front).get(i)).isEmpty()){
                for(int j=0;j<Individual_Dominate.get(Front.get(front).get(i)).size();j++){
                    Individual_Number[Individual_Dominate.get(Front.get(front).get(i)).get(j)]=Individual_Number[Individual_Dominate.get(Front.get(front).get(i)).get(j)]-1;
                    if(Individual_Number[Individual_Dominate.get(Front.get(front).get(i)).get(j)]==0){
                        Solutions_to_arrange[Individual_Dominate.get(Front.get(front).get(i)).get(j)][Input.General_Inputs.Num_objectives+Input.General_Inputs.Num_Of_Ppes]=front+1;
                        Q.add(Individual_Dominate.get(Front.get(front).get(i)).get(j));
                    }
                }
            }
        }
    front++;
        for(int i=0;i<Q.size();i++)
        Front.get(front).add(Q.get(i));
    }