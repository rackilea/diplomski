final jenkins = Jenkins.instance

int executorCount = 0
for (def computer in jenkins.computers) {
    executorCount += computer.numExecutors
}

// Rest of pipeline