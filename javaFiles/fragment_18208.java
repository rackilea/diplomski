try {
        Git git = Git.open(new File("E:/foo/.git"));
        RefSpec spec = new RefSpec("b8d35be23d9f4574c9da81cf2fddb4212daf92a1:refs/heads/newbranch");
        git.push().setRemote("bar").setRefSpecs(spec).call();            
} catch (Exception e) {
        System.out.println(e);
}