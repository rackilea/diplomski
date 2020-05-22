package com.google.cloud.examples.storage.snippets;

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.StorageRoles;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** This class contains Bucket-level IAM snippets for the {@link Storage} interface. */
public class BucketIamSnippets {

  /** Example of listing the Bucket-Level IAM Roles and Members */
  public Policy listBucketIamMembers(String bucketName) {
    // [START view_bucket_iam_members]
    // Initialize a Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // Get IAM Policy for a bucket
    Policy policy = storage.getIamPolicy(bucketName);

    // Print Roles and its identities
    Map<Role, Set<Identity>> policyBindings = policy.getBindings();
    for (Map.Entry<Role, Set<Identity>> entry : policyBindings.entrySet()) {
      System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
    }
    // [END view_bucket_iam_members]
    return policy;
  }

  /** Example of adding a member to the Bucket-level IAM */
  public Policy addBucketIamMember(String bucketName, Role role, Identity identity) {
    // [START add_bucket_iam_member]
    // Initialize a Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // Get IAM Policy for a bucket
    Policy policy = storage.getIamPolicy(bucketName);

    // Add identity to Bucket-level IAM role
    Policy updatedPolicy =
        storage.setIamPolicy(bucketName, policy.toBuilder().addIdentity(role, identity).build());

    if (updatedPolicy.getBindings().get(role).contains(identity)) {
      System.out.printf("Added %s with role %s to %s\n", identity, role, bucketName);
    }
    // [END add_bucket_iam_member]
    return updatedPolicy;
  }


  public static void removeUserFromBucketUsingEmail(String bucketName, Role role, String email)  {

        Storage storage = StorageOptions.getDefaultInstance().getService(); 
        Policy policy = storage.getIamPolicy(bucketName);
        Identity identity = Identity.serviceAccount(email);
        String eTag = policy.getEtag();
        System.out.println("etag: " + eTag);

        Policy updatedPolicy = storage.setIamPolicy(bucketName, policy.toBuilder().removeIdentity(role, identity).build());

    if (updatedPolicy.getBindings().get(role) == null
        || !updatedPolicy.getBindings().get(role).contains(identity)) {
      System.out.printf("Removed %s with role %s from %s\n", identity, role, bucketName);
    }


    }


public static void main(String... args) throws Exception {

    try
    {

    String bucketName = "my-bucket-name";

    BucketIamSnippets obj = new BucketIamSnippets ();
    Role role_admin = StorageRoles.objectAdmin();

    String acc_1 = "test1@my.iam.gserviceaccount.com";
    String acc_2 = "test2@my.iam.gserviceaccount.com";
    Identity identity_1 = Identity.serviceAccount(acc_1);
    Identity identity_2 = Identity.serviceAccount(acc_2);

     System.out.println(obj.addBucketIamMember (bucketName, role_admin, identity_1 ));
     System.out.println(obj.addBucketIamMember (bucketName, role_admin, identity_2 ));


      Storage storage = StorageOptions.getDefaultInstance().getService();
        Policy policy = storage.getIamPolicy(bucketName);
        System.out.println(policy);

        //List<Role> roleList = new ArrayList<>();
        List<Set<Identity>> identities = new ArrayList<>();
        // Print Roles and its identities
        Set<Identity> wrongIdentities = new HashSet<Identity>();
        Role aux = null;

        Map<Role, Set<Identity>> policyBindings = policy.getBindings();
        Set<Identity> setidentities = new HashSet<>();
        for (Map.Entry<Role, Set<Identity>> entry : policyBindings.entrySet()) {
            aux = entry.getKey();
            System.out.println("role plain " + aux);
            System.out.println("role other  " + aux.getValue());

            if (aux.getValue().equals("roles/storage.objectAdmin")) {
                System.out.println("role :" + aux.getValue());
                System.out.println("Identities getV :" + entry.getValue());
                System.out.println("Identities getK :" + entry.getKey());

                setidentities = entry.getValue();
                System.out.println("setidentities  :" + setidentities);
                System.out.println("setidentities size :" + setidentities.size());
                for (Identity set : setidentities) {
                    if ((set.equals("serviceAccount: test2@my.iam.gserviceaccount.com"))) {
                        System.out.println("strong one : " + set);
                        continue;
                    } else {
                        wrongIdentities.add(set);
                        System.out.println("strong one : " + set);

                    }

                    System.out.println("wrongIdentities.size() : " + wrongIdentities.size());

                }
            }

        }

        System.out.println("ww " + wrongIdentities);
        System.out.println("policyEtag " + policy.getEtag());
        //GCSFunctions function = new GCSFunctions(); 

        for (Identity identity : wrongIdentities) {
            BucketIamSnippets.removeUserFromBucketUsingEmail(bucketName, role_admin, identity.getValue());
        }


    }
    catch (Exception e)
    {
        e.printStackTrace ();
    }
}

}