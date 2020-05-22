public Task(Object[] parameters)
{
    this.number_of_sums = Integer.parseInt((String)parameters[0]);
    this.variables_per_sum = Integer.parseInt((String)parameters[1]);
    this.sums = new Sum[this.number_of_sums];
    int z = 0;

    for(int i = 0; i < this.number_of_sums; i++)
    {
        Object[] sum_parameters = new Object[this.variables_per_sum];
        int x = 0;
        for(int j = (2 + z); j < ((this.variables_per_sum + 2) + z); j++)
        {
            sum_parameters[x] = parameters[j];
            x++;
        }

        this.sums[i] = new Sum(sum_parameters);

        System.out.println("Index 0: "+sums[0]); //1st iteration: 1 + 1 //2nd iteration: 2 - 1
        System.out.println("Index 1: "+sums[1]); //1st iteration: null //2nd iteration: 2 - 1

        z += this.variables_per_sum;
    }
}