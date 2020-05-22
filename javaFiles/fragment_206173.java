P[fails within first x steps]
  = 1 - P[does not fail within x steps]
  = 1 - P[AND_{k = 1}^x not(A_k)]
  = 1 - prod_{k=1}^x P[not(A_k)]     // independence assumption
  = 1 - prod_{k=1}^x (1 - P[A_k])
  = 1 - prod_{k=1}^x (1 - 1 + exp(-lambda * (age + k)))
  = 1 - prod_{k=1}^x exp(-lambda * (age + k))
  = 1 - exp(-lambda * age * x - lambda * sum_{k=1}^x k)
  = 1 - exp(-lambda * age * x) * exp(-lambda * x * (x + 1) / 2)