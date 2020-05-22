root = new DefaultTreeNode("root", null);
TreeNode projetNode = new DefaultTreeNode("node", new Document(projet), root);

        for (Tache ta : taches) {
            TreeNode tacheNode = new DefaultTreeNode("node", new Document(ta), projetNode);   
            for (Activite ac : activites) {
                Tache tache = ac.getTache();
                if (tache.getId() != ta.getId()) { continue;}
                TreeNode activiteNode = new DefaultTreeNode("node", new Document(ac), tacheNode);

                for (Phase ph : phases) {
                    Activite activite = ph.getActivite();
                    if (activite.getId() != ac.getId()) {continue;}
                    TreeNode phaseNode = new DefaultTreeNode("leaf", new Document(ph), activiteNode);
                }
            }
        }