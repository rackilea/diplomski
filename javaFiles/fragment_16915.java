import java.util.*;
import java.io.*;

class Countwords {
    public static String[] MWTs = { "Hong Kong", "New York", "United Kingdom",
            "Basic Law", "Poeple's Republic of China",
            "Hong Kong Special Adminstrative Region", "Chief Excutive",
            "Chief Justice", "Chief Secretary for Adminstrative",
            "Interpretation and General Clauses Ordinance",
            "Hong Kong Bill of Rights",
            "Central People's Government of the People's Republic of China",
            "Administrative Appeals Board", "Chief Executive in Council",
            "Executive Council", "Court of Final Appeal",
            "Court of First Instance", "District Council", "District Court",
            "District Judge", "Financial Secretary",
            "Hong Kong Government Gazette", "Gazette Extraordinary",
            "Special Gazette", "General Holidays Ordinance",
            "Financial Services and the Treasury",
            "Government Logistics Department", "Deputy Director",
            "Assistant Director of Health", "High Court",
            "Ministry of Foreign Affairs", "New Kowloon", "New Territories",
            "Provisional Legislative Council", "District Council",
            "Executive Council", "Central Authorities", "Hong Kong Time",
            "Financial Secretary", "Secretary for Justice",
            "Secretary for the Civil Service",
            "Secretary for Commerce, Industry and Technology",
            "Secretary for Constitutional Affairs",
            "Secretary for Economic Development and Labour",
            "Secretary for Education and Manpower",
            "Secretary for the Environment, Transport and Works",
            "Secretary for Financial Services and the Treasury",
            "Secretary for Health, Welfare and Food",
            "Secretary for Home Affairs",
            "Secretary for Housing, Planning and Lands",
            "Secretary for Security", "Permanent Secretary",
            "Director of Home Affairs", "Director of Administration",
            "Deputy Secretary", "Deputy Director of Administration",
            "Principal Assistant Secretary",
            "Assistant Director of Administration",
            "Independent Commission Against Corruption",
            "Principal Investigator", "Operations Department",
            "Immigration Service", "Customs and Excise Service",
            "Chief Superintendent", "Customs and Excise Service ",
            "Her Majesty", "British Governmen", "Secretary of State",
            "Privy Council", "Her Majesty in Counci",
            "British Dependent Territories", "Channel Islands", "Isle of Man",
            "British Nationality Act",
            "United Kingdom of Great Britain and Northern Ireland",
            "Northern Ireland", "Administrative Appeals Rules",
            "Public Office Ordinance", "Chief Justice Bankruptcy Ordinance", };

    public static void bubble_sort_length(String[] strs) {
        while (true) {
            int swaps = 0;
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].length() >= strs[i + 1].length())
                    continue;
                String tmp = strs[i];
                strs[i] = strs[i + 1];
                strs[i + 1] = tmp;
                swaps++;
            }
            if (swaps == 0)
                break;
        }
    }

    public static void main(String[] args) {
        bubble_sort_length(MWTs);
        System.out.println(Arrays.toString(MWTs));
    }
}