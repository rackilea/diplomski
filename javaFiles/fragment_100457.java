final Comparator<CmsResource> CREATE_ORDER = new Comparator<CmsResource>() {
     public int compare(CmsResource one, CmsResource another) {
         Date oneCreated = null;
         Date anotherCreated = null;
         try {
             oneCreated = new Date(one.getDateCreated());
             anotherCreated = new Date(another.getDateCreated());
         } catch (Exception e) {
             oneCreated = null;
             anotherCreated = null;
             return 0;
         }
         if ( oneCreated.after(anotherCreated))
            return 1;
         else if ( oneCreated.before(anotherCreated))
            return -1;
         else
            return 0;
     }
 };
 Collections.sort(categoryResourcesNewBies,CREATE_ORDER);