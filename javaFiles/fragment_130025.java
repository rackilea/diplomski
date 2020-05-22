let query = {};
// this is one of the dropdown value
if (this.SearchText) {
    query['q'] =  SearchText;
   }
// this is the second one of dropdown value 
if (this.MakeId) {
    makename = this.SpaceToDash(this.MakesList.find(x => x.Id === +this.MakeId).Name);
    navigateUrl += '/' + makename;
    query['merk'] =  this.MakeId;
    query['makename'] =  makename;
   }
this.router.navigate([ navigateUrl ], { queryParams:  query  });