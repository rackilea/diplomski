v1 <- rbinom(100,size=1,p=.25)  
#create a vector, length 100, 
#where each entry corresponds to the 
#result of a bernoulli trial with probability p

binom.test(sum(v1), n=length(v1), p = 0)
##let's pretend we didn't just generate v1 ourselves, 
##we can use binom.test to determine the 95% CI for p

#now in terms of what you want to do...
#here's a dataset that might be something like yours:
selectionArray <- sapply(runif(10), FUN=function(.p) rbinom(100,size=1,p=.p))
#I'm just generating 10 vectors from a binomial distribution 
#where each entry corresponds to 1 trial and each column 
#has a randomly generated p between 0 and 1

#using a for loop
#run a binomial test on each column, store the results in binom.test.results
binom.test.results <- list()
for(i in 1:ncol(selectionArray)){
    binom.test.results[[i]] <- binom.test(sum(selectionArray[,i]), 
        n=nrow(selectionArray), p=0)
}

#for loops are considered bad programming in r, so here's the "right" way to do it:
binom.test.results1 <- lapply(as.data.frame(selectionArray), function(.v){
    binom.test(sum(.v), n=nrow(selectionArray), p = 0)
})

#using str() on a single element of binom.test.result will help you 
#identify what results you'd like to extract from each test