void Loops::testForLoopCreateInt(LONGLONG numberOfIterations)
{
    cout << "\n===========================" << "\ntestForLoopCreateInt() Looping for: " << numberOfIterations << endl;
    vector<int> vectorOfInts;

    high_resolution_clock::time_point startTime = high_resolution_clock::now();
    for (LONGLONG counter = 0; counter < numberOfIterations; counter++)
    {
        int i = 0;
        vectorOfInts.push_back(i);
    }
    high_resolution_clock::time_point endTime = high_resolution_clock::now();

    duration<double, std::milli> totalTime = endTime - startTime;
    cout << "Total time: " << totalTime.count() << " milliseconds" << endl;
    cout << "===========================testForLoopCreateInt()" << endl;

    for (int indexer = 0; indexer < 10; indexer++) {
        int y = vectorOfInts.at(indexer);
    }
}