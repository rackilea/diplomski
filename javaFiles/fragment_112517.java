class ChangeRequestBean implements Comparable<ChangeRequestBean> {

        public int compareTo(ChangeRequestBean  bean) {
             return this.changerequestid   - bean.changerequestid ;
        }       
    }