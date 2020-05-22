void Loops::testForLoopCreateUniformStringAndStoreToVector(LONGLONG numberOfIterations)
{
    cout << "\n===========================" << "\ntestForLoopCreateUniformStringAndStoreToVector() Looping for: " << numberOfIterations << endl;
    vector<string> vectorOfStrings;

    high_resolution_clock::time_point startTime = high_resolution_clock::now();
    for (LONGLONG counter = 0; counter < numberOfIterations; counter++)
    {
        string str000("01234");
        vectorOfStrings.push_back(str000);
    }
    high_resolution_clock::time_point endTime = high_resolution_clock::now();

    duration<double, std::milli> totalTime = endTime - startTime;
    cout << "Total time: " << totalTime.count() << " milliseconds" << endl;
    cout << "===========================testForLoopCreateUniformStringAndStoreToVector()" << endl;

    for (int indexer = 0; indexer < 10; indexer++) {
        string y = vectorOfStrings.at(indexer);
    }
}