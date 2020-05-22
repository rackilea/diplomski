{  // <= Root object (a JSON-object).
    "function": "create_contact_group", // <= Key in the root-object (where the key is a string and the value a string)
    "parameters": [ // <= Key in the root-object (where the key is a string and the value is an array.
        {  // <= Object inside the array.
            "user_id": "teer", // Key (string/string)
            "comp_id": "97",   // Key (string/string)
            "contact_group_name": "Test01", // Key (string/string)
            "invite_user_list": [  // Key (string/array)
                {   // Object inside the invite_user_list array
                    "invite_user_id": "steve"  // Key (string/string)
                }
            ]
        }
    ]
}