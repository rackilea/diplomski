function Model(data, parent)
{
    var self = this;
    self.parent = parent;

    self.Load = function(data) {
        if (data) {
            //initialize data here
        }
    };
    self.Load(data); //call initially here in case of initial state


    //other functionality
}