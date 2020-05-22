{ // Root (jsonObject)
    "invite_user_list": [
        { "invite_user_id": "steve" }
    ]
    "parameters": [
        { // The "map" hashmap
            "user_id", "teer",
            "comp_id": "97",
            "contact_group_name": "Test01"
        },
        {   // The jsonObject object (which is also the root!)
            "invite_user_list": [
                { "invite_user_id": "steve" }
            ],
            "parameters": [
                { // The "map" hashmap
                    "user_id", "teer",
                    "comp_id": "97",
                    "contact_group_name": "Test01"
                },
                {
                    // The jsonObject object again (which is also the root and the parent!)

                    // ... and so on til eternity!
                }
            ],
            "function": "create_contact_group" 
        }
    ],
    "function": "create_contact_group" 
}