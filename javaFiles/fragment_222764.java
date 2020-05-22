this.camera = this.universe.getViewingPlatform().getViewPlatformTransform();

         //Add things to the universe
         this.root = new BranchGroup();
         this.root.addChild(new ColorCube(0.2));
         this.universe.addBranchGraph(root);