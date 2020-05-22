try {
        YAML::Node firstTierNode = YAML::LoadFile("config.yml");

        std::map<std::string, std::map<std::string, std::map<std::string, std::string>>> newMap1;
        for (YAML::const_iterator it = firstTierNode.begin(); it != firstTierNode.end(); ++it) {

            string level1First = it->first.as<std::string>();

            YAML::Node secondTierNode = it->second;

            std::map<std::string, std::map<std::string, std::string>>  newMap2;
            for (YAML::const_iterator it = secondTierNode.begin(); it != secondTierNode.end(); ++it) {

                string level2First = it->first.as<std::string>();

                YAML::Node thirdTierNode = it->second;

                std::map<std::string, std::string> newMap3;
                for (YAML::const_iterator it = thirdTierNode.begin(); it != thirdTierNode.end(); ++it) {

                    string level3First = it->first.as<std::string>();

                    string level3SecondString = it->second.as<std::string>();

                    newMap3.insert(std::pair<std::string, std::string>(level3First, level3SecondString));
                }

                newMap2.insert(std::pair<std::string, std::map<string, string>>(level2First, newMap3));

            }

            newMap1.insert(std::pair<std::string, std::map<string, std::map<string, string>>>(level1First, newMap2));

        }

        for (const auto& x : newMap1) {
            std::cout <<x.first << endl << endl;
            for (const auto& y : x.second) {
                std::cout << y.first << endl << endl;
                for (const auto& z : y.second) {
                    std::cout << z.first << endl << z.second << endl << endl << endl;
                }
            }
        }

        return 1;
    }
    catch (exception& e) {
            cerr <<e.what()<< endl;
    }