massive_process_1 <- function() {
  x <- do_something()
  saveRDS(x, '/home/sc_evans/results/first_result.rds')      
}

massive_process_2 <- function() {
  x <- do_something()
  saveRDS(x, '/home/sc_evans/results/second_result.rds')      
}

massive_process_1()
massive_process_2()